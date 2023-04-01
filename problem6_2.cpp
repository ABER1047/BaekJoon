
#include <math.h>
#include <iostream>

using namespace std;
void quick_sort(int *data1, int *data2, int start, int end)
{
    if(start >= end)
    {
    // 원소가 1개인 경우
    return;
    }
    
    int pivot = start;
    int i = pivot + 1; // 왼쪽 출발 지점 
    int j = end; // 오른쪽 출발 지점
    int temp1, temp2;
    
    while(i <= j){
        // 포인터가 엇갈릴때까지 반복
        while(i <= end && data1[i] >= data1[pivot])
        {
        i++;
        }
        
        while(j > start && data1[j] <= data1[pivot])
        {
        j--;
        }
        
        if(i > j)
        {
        // 엇갈림
        temp1 = data1[j];
        temp2 = data2[j];
        data1[j] = data1[pivot];
        data2[j] = data2[pivot];
        data1[pivot] = temp1;
        data2[pivot] = temp2;
        }
        else
        {
        // i번째와 j번째를 스왑
        temp1 = data1[i];
        temp2 = data2[i];
        data1[i] = data1[j];
        data2[i] = data2[j];
        data1[j] = temp1;
        data2[j] = temp2;
        }
    } 
    
// 분할 계산
quick_sort(data1, data2, start, j - 1);
quick_sort(data1, data2, j + 1, end);
}
 

int main() 
{
int N, K;
int ans = 0, i = 0, j = 0, ii = 0, value, saved_M, fulled_bp_num = 0;

// 가격 > 무게 우선
// 젤 비싼 보석 찾기 (이미 챙긴거면 패스)
// 젤 비싼 보석을 최고로 딱 맞는 가방에 넣기 (없으면 버려)
// 무한 반복
cin >> N >> K;
int M[N], V[N], C[K], fulled_bp[K];

    for(i = 0; i < N; i++) 
    {
    cin >> M[i] >> V[i];
    }

    for(i = 0; i < K; i++) 
    {
    cin >> C[i];
    fulled_bp[i] = 0;
    }

// 보석을 가격별로 재배열
quick_sort(V,M,0,N-1);


    for(i = 0; i < N; i++) 
    {
    int founded_best_bp = -4, best_bp_i = -4;

        // 최적의 가방 찾기
        for(ii = 0; ii < K; ii++) 
        {
        int dis__ = abs(M[i] - C[ii]);

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
        fulled_bp_num++;

            if (fulled_bp_num == K) 
            {  
            // 모든 가방이 이미 꽉 찬 경우
            break;
            }
        }
    }

cout << ans;
return 0;
}