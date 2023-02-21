import java.util.*;

public class Main {
	
	public static int max(int a, int b) {
		if(a > b)
			return a;
		else
			return b;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		int[][] memo = new int[a.length()+1][b.length()+1];
		
		// 0으로 패딩 ( a를 세로, b를 가로 설정합니다.) 
		for(int i = 0; i <= a.length(); i++)
			memo[i][0] = 0;
		for(int i = 0; i <= b.length(); i++)
			memo[0][i] = 0;
		
		// 순환식을 따라 메모이제이션을 완성합니다.
		for(int i = 1; i <= a.length(); i++) {
			for(int j = 1; j <= b.length(); j++) {
				if(a.charAt(i-1) == b.charAt(j-1))
					memo[i][j] = memo[i-1][j-1] +1;
				else 
					memo[i][j] = max(memo[i-1][j], memo[i][j-1]);
			}
		}
		
		System.out.println(memo[a.length()][b.length()]);
		
		sc.close();
		return;
	}
}
