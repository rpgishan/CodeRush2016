
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gishan-mac
 */
public class DeadCellInvestigation {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt(), n = s.nextInt(), w = s.nextInt(), count = 0;
        int br[][] = new int[w][4];
        int grid[][] = new int[m][n];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < 4; j++) {
                br[i][j] = s.nextInt();
            }
            for (int j = br[i][0]; j <= br[i][2]; j++) {
                grid[br[i][1]][j] = 1;
            }
            if (br[i][2] == n - 1) {
                for (int j = 0; j < br[i][1]; j++) {
                    for (int k = br[i][0]; k <= br[i][2]; k++) {
                        grid[j][k] = 2;
                        count++;
                    }
                }
            }
        }

        F1:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && i < m - 1) {
                    int a = j;
                    while (grid[i + 1][a--] != 0) {
                        if (a < 0) {
                            grid[i][a] = 2;
                            count++;
                            continue F1;
                        } else if(grid[i+1][a] != 0) {
                            if (grid[i + 1][a] != 0) {
                                grid[i][a] = 2;
                                count++;
                            }
                        }
                    }
                    continue F1;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println("");
        }
        
        System.out.println(count);
    }
}
