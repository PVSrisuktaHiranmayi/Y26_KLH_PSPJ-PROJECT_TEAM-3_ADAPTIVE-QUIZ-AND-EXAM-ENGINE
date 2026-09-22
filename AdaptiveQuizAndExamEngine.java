import java.util.Scanner;
public class AdaptiveQuizAndExamEngine{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Student Roll Number: ");
        int rollno = sc.nextInt();
        System.out.println("Enter section: ");
        int sec = sc.nextInt();
        int count;
        int[] psp1 = new int[10];
        int[] mfc1 = new int[10];
        int[] ddca1 = new int[10];
        while(1==1){
            count = 0;
            System.out.println("Select subject (1-PSP, 2-MFC, 3-DDCA): ");
            int subject = sc.nextInt();
        switch (subject){
            case 1: 
            int[] psp = {1,2,3,4,1,2,3,4,1,2};
            System.out.println("Enter your answers: ");
            for(int i = 0; i < psp1.length; i++){
                psp1[i] = sc.nextInt();
            }
            for(int i = 0; i < psp1.length; i++){
                if(psp[i] == psp1[i])
                    count++;
            
            }
            System.out.println("Answer key: ");
            for(int i = 0; i<psp.length; i++){
            System.out.print(psp[i]+" ");
            }
            System.out.println("Number of questions correct = "+count);
            System.out.println("Percentage = "+(count*10)+"%");
            break;

            case 2: 
            int[] mfc = {4,3,2,1,4,3,2,1,4,3};
            System.out.println("Enter your answers: ");
            for(int i = 0; i < mfc.length; i++){
                mfc1[i] = sc.nextInt();
            }
            for(int i = 0; i < mfc1.length; i++){
                if(mfc[i] == mfc1[i]){
                    count++;
                }
            }
            System.out.println("Answer key: ");
            for(int i = 0; i<mfc.length; i++){
            System.out.print(mfc[i]+" ");
            }
            System.out.println("Number of questions correct = "+count);
            System.out.println("Percentage = "+(count*10)+"%");
            count = 0;
            break;

            case 3: 
            int[] ddca = {1,2,3,4,4,3,2,1,1,4};
            System.out.println("Enter your answers: ");
            for(int i = 0; i < ddca.length; i++){
                ddca1[i] = sc.nextInt();
            }
            for(int i = 0; i < ddca1.length; i++){
                if(ddca[i] == ddca1[i]){
                    count++;
                }
            }
            System.out.println("Answer key: ");
            for(int i = 0; i<ddca.length; i++){
            System.out.print(ddca[i]+" ");
            }
            System.out.println("Number of questions correct = "+count);
            System.out.println("Percentage = "+(count*10)+"%");
            break;

            default: System.out.println("Invalid input. Please enter a valid number between 1-3.");

            sc.nextLine();

            }
 
            System.out.println("Do you want to continue? (True/False): ");
            boolean cont = sc.nextBoolean();
            if(!cont){
                return;
            }

        }
        
    }
}