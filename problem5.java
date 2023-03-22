import java.util.*;

public class problem5 
{
    public static void main(String[] args)
    {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int budget[] = new int[N], total = 0;
    
        for(int i = 0; i < N; i++)
        {
        budget[i] = sc.nextInt();
        total += budget[i];
        }
    int M = sc.nextInt(), real_M = M, num = 0, M_cal = 0;
    
        for(int i = 0; i < N; i++)
        {
            if (total > M)
            {
                if (budget[i] <= M/N)
                {
                real_M -= budget[i];
                }
                else
                {
                num ++;
                }
            }
            else
            {
            M_cal = (budget[i] > M_cal) ? budget[i] : M_cal;
            }
        }
        
    int ans = (total > M) ? real_M/num : M_cal;
    System.out.print(ans);
    }
}
