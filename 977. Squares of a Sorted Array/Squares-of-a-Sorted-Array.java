class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();

        for(int num : nums){
            if(num < 0){
                negative.add(num);
            }
            else{
                positive.add(num);
            }
        }

        //case 1: If all numbers are positive
        if(negative.size() == 0){
            for(int i = 0 ;  i < positive.size() ; i++)
                positive.set(i , positive.get(i) * positive.get(i));
                return positive.stream().mapToInt(Integer::intValue).toArray(); 
        }

        //Case 2: If all numbers are negative
        if(positive.size() == 0){
            for(int i = 0 ; i < negative.size() ; i++)
                negative.set(i, negative.get(i) * negative.get(i));
                Collections.reverse(negative);
                return negative.stream().mapToInt(Integer::intValue).toArray();
        }

            int arr1 = negative.size();
            int arr2 = positive.size();
            int[] result = new int[arr1 + arr2];

            //square all the negative values and reverse the list
            for(int i = 0 ; i < arr1 ; i++){
                negative.set(i , negative.get(i) * negative.get(i));
            }
                Collections.reverse(negative);
            
            //square all the positive values
            for(int i = 0 ; i < arr2 ; i++)
                positive.set(i , positive.get(i) * positive.get(i));
                        
            int i = 0;
            int j = 0;
            int id = 0;

            // Merge both sorted lists
            while(i<arr1 && j<arr2){
                if(negative.get(i) <= positive.get(j)){
                    result[id++] = negative.get(i++);
                }
                else{
                    result[id++] = positive.get(j++);
                }
            }
            // Merge-case1: if remain 1 last negative value
            while(i<arr1){
                result[id++] = negative.get(i++);
            }

            // Merge-case1: if remain 1 last positive value
            while(j<arr2){
                result[id++] = positive.get(j++);
            }

            return result;
    }
}