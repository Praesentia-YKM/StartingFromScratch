import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		System.out.print(st.countTokens());
	}
}

문자열을 읽고 charAt 을 통해 공백을 검사하는 방법
StringTokenizer 을 사용하는 방법
