import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[][] sudoku = new int[9][9];
	static boolean[][][]isUsed = new boolean[2][9][10]; //(행,열)가로,세로 줄 1~9유무를 확인할 배열
	static boolean[][] smallUsed = new boolean[9][10]; //3x3 박스에 사용한 수인지 확인할 배열 왼쪽 위부터 0번 오른쪽으로 진행
	
	static boolean solve(int idx) {
		if (idx >= 81) {//끝칸까지 채웠으면 스도쿠 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]+"");
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            return true;
		}

        int r = idx / 9, c = idx % 9; //idx로 행, 열

        if (sudoku[r][c] != 0) {
        	if(solve(idx+1)) { //숫자면 다음으로
        		return true;
        	};
        }else { //빈칸이면
            for (int i = 1; i < 10; i++) {//1부터 9까지
                if (isUsed[0][r][i] || isUsed[1][c][i] || smallUsed[3*(r/3)+c/3][i]) continue; //행,열,3x3 박스에 있는 수면 pass
                isUsed[0][r][i] = true;
                isUsed[1][c][i] = true;
                smallUsed[3*(r/3)+c/3][i] = true;
                sudoku[r][c] = i;
                if(solve(idx+1)) {
                	return true;
                }
                isUsed[0][r][i] = false;
                isUsed[1][c][i] = false;
                smallUsed[3*(r/3)+c/3][i] = false;
                sudoku[r][c] = 0;
            }
        }
        return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			char[]row = br.readLine().toCharArray();
			for(int j=0;j<9;j++) {
				sudoku[i][j] = row[j]-'0';
				isUsed[0][i][row[j]-'0'] = true; //i번쨰 열에 해당 값이 있는지
				isUsed[1][j][row[j]-'0'] = true; //j번쨰 행에 해당 값이 있는지 
				smallUsed[3*(i/3) + (j/3)][sudoku[i][j]] = true;//해당 위치의 3x3에 값이 있는지
			}
		}
		solve(0);
	}
}