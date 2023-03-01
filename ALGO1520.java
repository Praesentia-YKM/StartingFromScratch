import java.util.*;
 
public class Main {
    
    static Scanner scan = new Scanner(System.in);
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) { 
        int m = scan.nextInt();
        int n = scan.nextInt();
        
        int[][] node = new int[m][n];
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                node[i][j] = scan.nextInt();
                dp[i][j] = -1;
            }
        }
        
        int result = dfs(node, dp, 0, 0);
        System.out.println(result);
    }
    
    public static int dfs(int[][] node, int[][] dp, int x, int y) {
        if(x == node.length - 1 && y == node[0].length - 1) {
            return 1;
        }
        
        if(dp[x][y] == -1) {
            dp[x][y] = 0;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < node.length && ny < node[0].length) {
                    if(node[nx][ny] < node[x][y]) {
                        dp[x][y] += dfs(node, dp, nx, ny);
                    }
                }
            }
        }
        return dp[x][y];
    }
 }


DP문제로 dfs 풀이 방식과 매우 유사한 형식이였다. 그래서 많이 어렵지 않았다.
node함수로 지도의 정보를 입력받고, dp함수를 사용해 메모이제이션과 현재 까지 올 수 있는 경로의 수를 저장해 주었다.
dp함수가 초기값이면 그 방향으로 한번도 오지 않았다는 의미이므로 지도 값이 더 작은 곳이 주변에 위치하는지 확인하여 이동한다. 이때 이동 경로의 수를 더해준다. 
dp함수가 초기값이 아니면 현재 dp함수에 저장된 값을 반환해 준다. 
이때 dp함수 초기화 값이 중요하다. 초기화를 하지 않으면 기본적으로 0이 저장될 것인데 이 0은 node[x][y]로 이동할 수 있는 경우의 수가 0이라는 의미가 된다. 
즉 이미 경우의 수를 계산해서 0이 나왔는데도 불구하고 초기값이니까 또 계산하는 경우가 발생할 수 있다.
이를 방지하기위해 초기값을 -1로 설정해주었다.
