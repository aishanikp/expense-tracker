class solution {
    public int lengthOfLongestSubstring(String s) {
        int k=unique(s);String h="";
        if(k==s.length()){
            return k;
        }
        else{
            outer:
            for(int i=k;i>=1;i--){
                for(int j=0;j<(s.length()-i);j++){
                    h=s.substring(j,j+i);
                    if(isunique(h)){
                        break outer;
                    }
                    
                }
            }return h.length();
        }
       
    }
    public boolean isunique(String s){
        if(s.length()==unique(s)){
            return true;
        }
        else{
            return false;
        }

    }
    public int unique(String s){
        String n="";
        char[] l=s.toCharArray();
        for(char c:l){
            if(n.indexOf(c)==-1){
                n=n+c;
            }
        }
        return n.length();

    }
}public class solution {

}
