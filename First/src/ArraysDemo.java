public class ArraysDemo {
    public static void main(String[] args) {
        // int scores[] = new int[2];
        int scores[] = {34,4};

        // scores[0] = 34;
        // scores[1] = 4;

        System.out.println(scores);

        // for(int i=0;i<=scores.length;i++){
        //     System.out.println(scores[i]);
        // }

        for(int score: scores){
            System.out.println(score);
        }
    }
}
