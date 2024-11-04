class Solution {
    public String compressedString(String word) {
        StringBuilder comp=new StringBuilder("");
        char[] ch=word.toCharArray();
        int i=0;
        
        while(i<word.length()){
            int count=0;
            char character=ch[i];
            while(i<ch.length && count<9 && character==ch[i]){
                count+=1;
                i+=1;
            }
            comp.append(count);
            comp.append(character);
        }
        String result=comp.toString();
        return result;
    }
}