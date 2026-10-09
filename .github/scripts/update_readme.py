import json
import re
import urllib.request
from pathlib import Path

ROOT = Path(".")
README = ROOT / "README.md"

START = "<!-- AUTO_DSA_START -->"
END = "<!-- AUTO_DSA_END -->"

PATTERNS = [
    ("🔥 Monotonic Stack", {"monotonic-stack"}),
    ("🪟 Sliding Window", {"sliding-window"}),
    ("👉 Two Pointers", {"two-pointers"}),
    ("📊 Prefix Sum", {"prefix-sum"}),
    ("🧮 HashMap / HashSet", {"hash-table"}),
    ("📚 Stack", {"stack"}),
    ("🔗 Linked List", {"linked-list"}),
    ("📅 Intervals", {"interval"}),
    ("🔍 Binary Search", {"binary-search"}),
    ("⚡ Heap / Priority Queue", {"heap-priority-queue"}),
    ("🔙 Backtracking", {"backtracking"}),
    ("🧠 Dynamic Programming", {"dynamic-programming"}),
    ("💰 Greedy", {"greedy"}),
    ("🌐 Graph", {"graph", "breadth-first-search", "depth-first-search"}),
    ("🌳 Tree", {"tree", "binary-tree", "binary-search-tree"}),
    ("🔤 Strings", {"string"}),
    ("💡 Bit Manipulation", {"bit-manipulation"}),
    ("➗ Math", {"math"}),
    ("↕️ Sorting", {"sorting"}),
    ("📦 Arrays", {"array"}),
]

def slug_from_folder(name: str) -> str:
    # Remove the numeric LeetCode prefix.
    value = re.sub(r"^0*\d+\s*[-.]?\s*", "", name)
    value = value.strip().lower()
    value = re.sub(r"[^a-z0-9]+", "-", value).strip("-")
    return value

def problem_number(name: str):
    match = re.match(r"^0*(\d+)", name)
    return int(match.group(1)) if match else None

def find_java_problem_folders():
    candidates = {}

    for path in ROOT.iterdir():
        if not path.is_dir():
            continue

        number = problem_number(path.name)
        if number is None:
            continue

        java_files = list(path.glob("*.java"))
        if not java_files:
            continue

        # Prefer the normal non-zero-padded folder and then shorter names.
        score = (
            1 if path.name.startswith("0") else 0,
            len(path.name),
            path.name.lower(),
        )

        candidates.setdefault(number, []).append((score, path, java_files))

    selected = []
    for number, items in candidates.items():
        items.sort(key=lambda item: item[0])
        _, folder, java_files = items[0]
        selected.append((number, folder, java_files[0]))

    return sorted(selected, key=lambda item: item[0])

def fetch_leetcode(slug: str):
    query = """
    query questionData($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        questionId
        title
        titleSlug
        difficulty
        topicTags {
          name
          slug
        }
      }
    }
    """

    payload = json.dumps({
        "query": query,
        "variables": {"titleSlug": slug},
    }).encode()

    request = urllib.request.Request(
        "https://leetcode.com/graphql",
        data=payload,
        headers={
            "Content-Type": "application/json",
            "User-Agent": "Mozilla/5.0 LogicBuildingREADME/1.0",
        },
        method="POST",
    )

    try:
        with urllib.request.urlopen(request, timeout=15) as response:
            data = json.load(response)

        question = data.get("data", {}).get("question")
        return question
    except Exception as exc:
        print(f"Could not fetch LeetCode data for {slug}: {exc}")
        return None

def choose_pattern(tags):
    tag_slugs = {tag.get("slug", "") for tag in tags}

    for title, accepted in PATTERNS:
        if tag_slugs & accepted:
            return title

    return "🧩 Other"

def level_icon(difficulty):
    return {
        "Easy": "🟢 Easy",
        "Medium": "🟡 Medium",
        "Hard": "🔴 Hard",
    }.get(difficulty, "⚪ Unknown")

def github_path(path: Path):
    return str(path).replace("\\", "/")

def leetcode_url(slug):
    return f"https://leetcode.com/problems/{slug}/"

def generate_dsa_section():
    grouped = {}

    for _, folder, java_file in find_java_problem_folders():
        slug = slug_from_folder(folder.name)
        question = fetch_leetcode(slug)

        if question:
            number = int(question["questionId"])
            title = question["title"]
            difficulty = question["difficulty"]
            tags = question.get("topicTags", [])
            actual_slug = question["titleSlug"]
        else:
            number = problem_number(folder.name)
            title = re.sub(r"^0*\d+\s*[-.]?\s*", "", folder.name).strip()
            difficulty = None
            tags = []
            actual_slug = slug

        pattern = choose_pattern(tags)

        row = {
            "number": number,
            "title": title,
            "difficulty": level_icon(difficulty),
            "code": github_path(java_file),
            "leetcode": leetcode_url(actual_slug),
        }

        grouped.setdefault(pattern, []).append(row)

    lines = [
        "## 📌 Solved DSA Problems",
        "",
        "Only problems that have a Java solution in this repository are listed below.",
        "",
    ]

    for pattern, problems in grouped.items():
        lines.append(f"### {pattern}")
        lines.append("")
        lines.append("| Problem | Level | Code |")
        lines.append("|---|---|---|")

        seen = set()
        for problem in sorted(problems, key=lambda item: (item["number"], item["title"].lower())):
            key = problem["number"]
            if key in seen:
                continue
            seen.add(key)

            code = f"[Java]({problem['code'].replace(' ', '%20')})"
            lines.append(
                f"| [{problem['number']}. {problem['title']}]({problem['leetcode']}) "
                f"| {problem['difficulty']} | {code} |"
            )

        lines.append("")

    lines.append("<!-- AUTO_DSA_END -->")
    return START + "\n" + "\n".join(lines[:-1]) + "\n" + lines[-1]

def update_readme():
    content = README.read_text(encoding="utf-8")

    generated = generate_dsa_section()

    start = content.find(START)
    end = content.find(END)

    if start != -1 and end != -1:
        end += len(END)
        new_content = content[:start] + generated + content[end:]
    else:
        marker_start = content.find("## ☕ Java Practice")
        if marker_start == -1:
            raise RuntimeError("Could not find the Java Practice section in README.md")

        new_content = (
            content[:marker_start]
            + generated
            + "\n\n"
            + content[marker_start:]
        )

    README.write_text(new_content, encoding="utf-8")

if __name__ == "__main__":
    update_readme()
    print("README updated.")
