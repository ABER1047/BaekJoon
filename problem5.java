import java.util.*;

public class problem5 
{
    public static void main(String[] args)
    {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int budget[] = new int[N], total = 0, max = 0, min = 0;
    
        for(int i = 0; i < N; i++)
        {
        budget[i] = sc.nextInt();
        total += budget[i];
            if (i == 0)
            {
            min = budget[i];
            max = budget[i];
            }
            else
            {
                if (budget[i] < min)
                {
                min = budget[i];
                }
                
                if (budget[i] > max)
                {
                max = budget[i];
                }
            }
        }
    int M = sc.nextInt(), real_M = M, num = 0, M_cal = 0;
    int middle = (max+min)/2;
    int standard = (min+max >= M) ? M/N : middle;
    
        for(int i = 0; i < N; i++)
        {
            if (total > M)
            {
                if (budget[i] <= standard)
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
        
    int ans = (total >= M) ? real_M/(num == 0 ? 1 : num) : M_cal;
    System.out.println(ans);
    }
}
