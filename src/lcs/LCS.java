/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcs;

/**
 *
 * @author mahinjm
 */
public class LCS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String p = "ACBDEA";
        String q = "ABCDEA";
        
        System.out.println(LCSDP(p, q, p.length(), q.length()));
        
        System.out.println(LCSDP(p, q, p.length(), q.length()));
        
    }
    
    
    //Longest Common Sequence in Recursion
    public static int LCS(String p,String q, int n, int m){
        int result=0;
        
        if(n==0||m==0){
            return 0;
        }
        
        if(p.charAt(n-1)==q.charAt(m-1)){
            result = 1 + LCS(p, q, n-1, m-1);
        }
        
        if(p.charAt(n-1)!=q.charAt(m-1)){
            result = Math.max(LCS(p, q, n-1, m), LCS(p, q, n, m-1));
        }
        
        return result;
    }
    
    
    
    //Longest Common Sequence in Dynamic Problem
    public static int LCSDP(String p,String q, int n, int m){
        int result[][] = new int[n+1][m+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(n==0||m==0){
                    return 0;
                }
                if(p.charAt(i-1)==q.charAt(j-1)){
                    result[i][j] = 1 + LCSDP(p, q, i-1, j-1);
                }

                if(p.charAt(i-1)!=q.charAt(j-1)){
                    result[i][j] = Math.max(LCSDP(p, q, i-1, j), LCSDP(p, q, i, j-1));
                }
            }
        }
        
        return result[n][m];
    }
    
}
