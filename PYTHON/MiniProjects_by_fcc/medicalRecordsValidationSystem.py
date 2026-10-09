# Build a Python program that validates medical records by checking data types, required fields,
#  and format constraints using loops, conditions, dictionaries, and regular expressions

import re

# Sample medical records dataset
medical_records = [
    {
        'patient_id': 'P1001',
        'age': 34,
        'gender': 'Female',
        'diagnosis': 'Hypertension',
        'medications': ['Lisinopril'],
        'last_visit_id': 'V2301',
    },

    {
        'patient_id': 'p1002',
        'age': 47,
        'gender': 'male',
        'diagnosis': 'Type 2 Diabetes',
        'medications': ['Metformin', 'Insulin'],
        'last_visit_id': 'v2302',
    },

    {
        'patient_id': 'P1003',
        'age': 29,
        'gender': 'female',
        'diagnosis': 'Asthma',
        'medications': ['Albuterol'],
        'last_visit_id': 'v2303',
    },

    {
        'patient_id': 'p1004',
        'age': 56,
        'gender': 'Male',
        'diagnosis': 'Chronic Back Pain',
        'medications': ['Ibuprofen', 'Physical Therapy'],
        'last_visit_id': 'V2304',
    }
]


# Function to check invalid fields
def find_invalid_records(
    patient_id,
    age,
    gender,
    diagnosis,
    medications,
    last_visit_id
):

    # Validation rules
    constraints = {

        'patient_id':
        isinstance(patient_id, str)
        and re.fullmatch('p\d+', patient_id, re.IGNORECASE),

        'age':
        isinstance(age, int)
        and age >= 18,

        'gender':
        isinstance(gender, str)
        and gender.lower() in ('male', 'female'),

        'diagnosis':
        isinstance(diagnosis, str)
        or diagnosis is None,

        # medications should be list and every item inside list should be string
        'medications':
        isinstance(medications, list)
        and all(isinstance(i, str) for i in medications),

        # last_visit_id should follow v + digits pattern
        'last_visit_id':
        isinstance(last_visit_id, str)
        and re.fullmatch('v\d+', last_visit_id, re.IGNORECASE)
    }

    # Return all invalid field names
    return [key for key, value in constraints.items() if not value]


# Main validation function
def validate(data):

    # Check if input is list or tuple
    is_sequence = isinstance(data, (list, tuple))

    if not is_sequence:
        print('Invalid format: expected a list or tuple.')
        return False

    # Variable to track invalid data
    is_invalid = False

    # Expected keys inside each dictionary
    key_set = {
        'patient_id',
        'age',
        'gender',
        'diagnosis',
        'medications',
        'last_visit_id'
    }

    # Traverse each record with index
    for index, dictionary in enumerate(data):

        # Check if each item is dictionary
        if not isinstance(dictionary, dict):
            print(
                f'Invalid format: expected a dictionary at position {index}.'
            )
            is_invalid = True
            continue

        # Check if dictionary has correct keys
        if set(dictionary.keys()) != key_set:
            print(
                f'Invalid format: {dictionary} at position {index} has missing and/or invalid keys.'
            )
            is_invalid = True
            continue

        # Find invalid fields in current dictionary
        invalid_records = find_invalid_records(**dictionary)

        # Loop through invalid fields
        for key in invalid_records:
            print(
                f"Unexpected format '{key}: {dictionary[key]}' at position {index}."
            )
            is_invalid = True

    if is_invalid:
        return False

    print('Valid format.')

    return True

validate(medical_records)