import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
    Scanner sc = new Scanner(System.in);

    int[] budget_req = new int[sc.nextInt()];
    int max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < budget_req.length; i++) 
        {
        sum += budget_req[i] = sc.nextInt();
            if (max < budget_req[i]) 
            {
            max = budget_req[i];
            }
        }

    int budget_total = sc.nextInt();

        if (sum < budget_total) 
        {
        System.out.println(max);
        } 
        else 
        {
        System.out.println(findMaxBudget(1, max, budget_total, budget_req));
        }
    }

    static int findMaxBudget(int lowest_budget, int largest_budget, int budget_total, int[] budget_req) 
    {
    int mid_budget = (largest_budget + lowest_budget) / 2;
    int check = check(mid_budget, budget_total, budget_req);
    
        if (lowest_budget > largest_budget) 
        {
        return mid_budget;
        }

        if (check > 0) 
        {
        return findMaxBudget(mid_budget + 1, largest_budget, budget_total, budget_req);
        } 
        else if (check < 0) 
        {
        return findMaxBudget(lowest_budget, mid_budget - 1, budget_total, budget_req);
        }

    return mid_budget;
    }

    // 총 금액이 더 크면 0 이상, 작으면 0 이하, 같으면 0
    static int check(int max_budget, int total_budget, int[] budget_req) 
    {
        for (int i = 0; i < budget_req.length; i++) 
        {
        total_budget -= Math.min(budget_req[i], max_budget); //중간값이랑 비교해서 작으면 -1, 크면 1 같으면 0
        
            if (total_budget < 0) 
            {
            return -1;
            }
        }
    return total_budget == 0 ? 0 : 1;
    }
}