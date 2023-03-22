import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Math;

public class problem6 
{
    public static void main(String[] args) throws IOException
    {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer str = new StringTokenizer(br.readLine(), " ");


    int N = Integer.parseInt(str.nextToken()); //N은 보석갯수
    int K = Integer.parseInt(str.nextToken()); //가방 갯수
    
    int M[] = new int[N]; //보석의 무게
    int V[] = new int[N]; //보석의 가격
    
    int C[] = new int[K]; //가방의 최대 무게
    
    int fulled_bp[] = new int[K], founded_best_bp = -4, ans = 0, max_repeat, total_gold = 0, n_max_gold, n_max_gold_i = -4, no_gems = 0, n_bp_fulled_num = 0, i, n_bp = 0, reset_skipped_one; //가방의 최대 무게
    int already_packed[] = new int[N];
    
    
    
        for(i = 0; i < N; i++)
        {
        str = new StringTokenizer(br.readLine(), " ");
            if (str.hasMoreTokens()) 
            {
            M[i] = Integer.parseInt(str.nextToken());
            V[i] = Integer.parseInt(str.nextToken());
            }
        }
        
        for(i = 0; i < K; i++)
        {
        str = new StringTokenizer(br.readLine(), " ");
            if (str.hasMoreTokens()) 
            {
            C[i] = Integer.parseInt(str.nextToken());
            }
        }
    
    //가격 > 무게우선
    //젤 비싼 보석 찾기 (이미 챙긴거면 패스)
    //젤 비싼 보석을 최고로 딱 맞는 가방에 넣기 (없으면 버려)
    //무한 반복
        while(ans == 0)
        {
        founded_best_bp = -4;
        n_max_gold = 0;
        reset_skipped_one = -4;
        
            if (n_bp_fulled_num <= K)
            {
            no_gems = 1;
                //젤 비싼 보석 찾기
                for(i = 0; i < N; i++)
                {
                    if (already_packed[i] != 1 && V[i] > n_max_gold)
                    {
                        if (reset_skipped_one != -4)
                        {
                        already_packed[reset_skipped_one] = 0;
                        }
                    already_packed[i] = 1;
                    n_max_gold = V[i];
                    n_max_gold_i = i;
                    no_gems = 0;
                    reset_skipped_one = n_max_gold_i;
                    }
                }
                
                if (no_gems == 0)
                {
                    //젤 비싼 보석 기준으로 가장 적합한 가방 찾기 (없으면 해당 보석은 패스)
                    for(i = 0; i < K; i++)
                    {
                        if (fulled_bp[i] == 0 && M[n_max_gold_i] <= C[i] && (founded_best_bp == -4 || Math.abs(M[n_max_gold_i] - C[i]) < founded_best_bp))
                        {
                        founded_best_bp = Math.abs(M[n_max_gold_i] - C[i]);
                        n_bp = i;
                        }
                    }
                    
                    if (founded_best_bp != -4)
                    {
                    fulled_bp[n_bp] = 1;
                    total_gold += V[n_max_gold_i];
                    n_bp_fulled_num ++;
                    }
                }
                else
                {
                ans = 1; //모든 보석을 이미 다 챙겼으면 반복문 빠져나가기
                }
            }
            else
            {
            ans = 1; //이미 모든 가방이 꽉찼으면 반복문 빠져나가기
            }
        }
        
    System.out.print(total_gold);
    }
}
