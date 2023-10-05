//Time Complexity: O(n*k) where n : average length of words, k: total no of words 
//Space Complexity: O(1) // HashMap of 26 chars
class Solution {
    Map<Character,Integer> hmap=new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        //use hashmap
        
        for(int i=0;i<order.length();i++)
        {
            hmap.put(order.charAt(i),i); //character and its index/locataion

        }
        boolean result;
        for(int i=0;i<words.length-1;i++)
        {
            result=chkIfNotSorted(words[i],words[i+1]);//compare consecutive words
            if(result==true)
            {
                return false;
            }
        }
        return true;    
    }
    public boolean chkIfNotSorted(String first,String second)
    {
        int len=Math.min(first.length(),second.length());
        for(int i=0;i<len;i++)
        {
            char fchar=first.charAt(i);
            char schar=second.charAt(i);
            if(fchar!=schar)
            {
                return hmap.get(fchar)>hmap.get(schar);// breach...if words are not sorted,returns true, else false
            }
            //else continue , chars are same
        }
        //in case of word finishes early

        return (first.length() > second.length());

    }

}
