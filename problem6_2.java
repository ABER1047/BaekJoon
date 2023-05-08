import java.util.*;
import java.io.*;

public class problem6_2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); //N은 보석갯수
        int K = Integer.parseInt(input[1]); //가방 갯수
        
        int M[] = new int[N]; //보석의 무게
        int V[] = new int[N]; //보석의 가격
        
        int C[] = new int[K]; //가방의 최대 무게
        
        int fulled_bp[] = new int[K];//가방의 최대 무게
        
        int ans = 0, i = 0, j = 0, ii = 0, value, saved_M, fulled_bp_num = 0;
        
    //가격 > 무게우선
    //젤 비싼 보석 찾기 (이미 챙긴거면 패스)
    //젤 비싼 보석을 최고로 딱 맞는 가방에 넣기 (없으면 버려)
    //무한 반복
        for(i = 0; i < N; i++)
        {
            input = br.readLine().split(" ");
            M[i] = Integer.parseInt(input[0]); //무게
            V[i] = Integer.parseInt(input[1]); //가격
        }
        
        for(i = 0; i < K; i++)
        {
            C[i] = Integer.parseInt(br.readLine()); //가방 최대 무게
            fulled_bp[i] = 0;
        }
        
        //보석을 가격별로 재배열
        for (i = 1; i < N; i++) 
        { 
            value = V[i];
            saved_M = M[i]; 

            for (j = i-1; j >= 0 && V[j] < value; j--) 
            {
                V[j+1] = V[j];
                M[j+1] = M[j];
            }
            
            V[j+1] = value;
            M[j+1] = saved_M;
        }


        for (i = 0; i < N; i++) 
        {
            int founded_best_bp = -4, best_bp_i = -4;
            //최적의 가방 찾기
            for (ii = 0; ii < K; ii++) 
            {
                int dis__ = Math.abs(M[i] - C[ii]);
            
                if (fulled_bp[ii] == 0 && M[i] <= C[ii] && (founded_best_bp == -4 || dis__ < founded_best_bp))
                {
                    founded_best_bp = dis__;
                    best_bp_i = ii;
                
                    if (dis__ == 0)
                    {
                        break;
                    }
                }
            }
            
            if (best_bp_i != -4)
            {
                fulled_bp[best_bp_i] = 1;
                ans += V[i];
                fulled_bp_num ++;
            
                if (fulled_bp_num == K) //모든 가방이 이미 꽉 찬 경우
                {
                    break;
                }
            }
        }
    
        //정답 출력
        bw.write(ans+"\n");
        bw.flush();
    }
}