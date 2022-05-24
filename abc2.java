import java.util.LinkedHashSet;

public class abc2 {
	static String nToS[][] = { { "O", "()", "0" }, 
			{ "I", "1" }, 
			{ "Z", "S", "7_", "2" }, // 5의 Z, S와 겹침
			{ "B", "E", "3" }, // 8의 B와 겹침
			{ "A", "4" }, { "Z", "S", "5" }, // 2의 Z, S와 겹침
			{ "b", "G", "6" }, { "T", "Y", "7" }, { "B", "E3", "8" }, // 3의 B와 겹침
			{ "g", "q", "9" } };
	static LinkedHashSet<String> lhs;

	public static void main(String[] args) {
		String[] numstrs = { "ZASSETE", "S4Z537B", "7_ASZEYB" };
		String[] words = { "2455373", "425", "373", "378" };
//		String[] numstrs = {"ZAZZ373"};
//		String[] words = {"2422373", "5455373", "2455373"};
		int answer[] = new int[words.length];

		for (int i = 0; i < words.length; i++) {
			lhs = new LinkedHashSet<>(); // 문자열 서로 안겹치게 넣기

			// 3, 8 : B 겹침 / && 2, 5 : Z, S 겹침
			numToStr(0, words[i].length(), words[i], new String[words[i].length()]);
			System.out.println(words[i] + "일 때 ");
			for (String str : lhs) {
				for (int j = 0; j < numstrs.length; j++) {
					System.out.println(str);
					if (numstrs[j].contains(str)) {
						answer[i]++;
					}
				}
			}
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}

	}

    private static void numToStr(int cnt, int N, String words, String[] modifiedStr){
        if(cnt == N){
            boolean chk[] = new boolean[6];

            for(int i = 0; i < modifiedStr.length; i++){
                int number = words.charAt(i) - '0';
                if(number == 3 || number == 8){
                    if(number == 3 && modifiedStr[i].equals("B") && chk[1]){
                        return;
                    }else if(number == 3 && modifiedStr[i].equals("B") && !chk[1]){
                        chk[0] = true;
                    }
                    if(number == 3 && modifiedStr[i].equals("B") && chk[0]){
                        return;
                    }else if(number == 3 && modifiedStr[i].equals("B") && !chk[0]){
                        chk[1] = true;
                    }
                }

                if(number == 2 || number == 5){
                    if(number == 2 && modifiedStr[i].equals("Z") && chk[3]){
                        return;
                    }else if(number == 2 && modifiedStr[i].equals("Z") && !chk[3]){
                        chk[2] = true;
                    }
                    if(number == 2 && modifiedStr[i].equals("Z") && chk[2]){
                        return;
                    }else if(number == 2 && modifiedStr[i].equals("Z") && !chk[2]){
                        chk[3] = true;
                    }
                }

                if(number == 2 || number == 5){
                    if(number == 2 && modifiedStr[i].equals("S") && chk[5]){
                        return;
                    }else if(number == 2 && modifiedStr[i].equals("S") && !chk[5]){
                        chk[4] = true;
                    }
                    if(number == 2 && modifiedStr[i].equals("S") && chk[4]){
                        return;
                    }else if(number == 2 && modifiedStr[i].equals("S") && !chk[4]){
                        chk[5] = true;
                    }
                }                
            }
            String temp = "";
            for(int i = 0; i < modifiedStr.length; i++){
                temp += modifiedStr[i];
            }
            lhs.add(temp);
            return;
        }

        int number = words.charAt(cnt) -'0'; 
        for(int j = 0; j < nToS[number].length; j++){
            modifiedStr[cnt] = nToS[number][j];
            numToStr(cnt +1, N, words, modifiedStr);
        }
    }
}
