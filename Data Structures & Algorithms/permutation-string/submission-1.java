class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()) return false;

        int[] arr = new int[26];
        for(int i = 0; i < s1.length(); i++){
            arr[s1.charAt(i) - 'a']++;
        }

        int[] arr2 = new int[26];

        int l = 0;
        for(int r = 0; r<s2.length();r++){
            
            boolean isSame = true;
            arr2[s2.charAt(r) - 'a']++;

            while(r - l + 1 > s1.length()){
                arr2[s2.charAt(l)-'a']--;
                l++;   
            }

            for(int i=0;i<26;i++){
                if(arr[i]!=arr2[i]){
                    isSame = false;
                    break;
                } 
            }

            if(isSame) return true;
        }

        return false;

    }
}
