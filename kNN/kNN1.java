import java.io.*;           //import library to work with files
import java.util.*;         //import library to use scanner and printwriter - to load and write txt files; Arrays
import java.lang.Math;      //import library to use the class Math

public class kNN1 {

    private static int TRAIN_SIZE = 200;    //size of the training set, which contains 200 paterns, given in train_data.txt file (reference: COMP5280_A2_Specification.pdf)
    private static int TEST_SIZE = 200;     //size of the test set, which contains 200 paterns, given in test_data.txt file (reference: COMP5280_A2_Specification.pdf)
    private static int FEATURE_SIZE = 61;   //each row in the file consists of 61 feature values representing either an alcoholic or control subject data (reference: COMP5280_A2_Specification.pdf)
    private static int k = 1;               //number of nearest neighbours used to make a prediction

    public static void main(String[] args) throws IOException {

        double[][] train = new double[TRAIN_SIZE][FEATURE_SIZE];        //the 2d array to store the training set
        double[][] test = new double[TEST_SIZE][FEATURE_SIZE];          //the 2d array to store the test set
        int[] train_label = new int[TRAIN_SIZE];                        //the array to store the train class labels
        int[] test_label = new int[TEST_SIZE];                          //the array to store the test class labels

        int[] predict = new int[TRAIN_SIZE];                            //array predict stores the predicted class labels 

        try (Scanner buffer = new Scanner(new File("train_data.txt"))) {    //the scanner used to load the training set to the train[][] array from the train_data.txt
            for (int i = 0; i < TRAIN_SIZE; i++) {                                   //loop goes from 0 to the TRAIN_SIZE
                for (int j = 0; j < FEATURE_SIZE; j++) {                             //loop goes from 0 to the FEATURE_SIZE
                    if (buffer.hasNextDouble()) {                                    //if the file has the next value of the type double, then
                        train[i][j] = buffer.nextDouble();                           //write the next double from the file to the corresponding position [TRAIN_SIZE][FEATURE_SIZE] in the array train, therefore each of 200 (patterns) rows will contain 61 (features) columns
                    }
                }
            }
            buffer.close();                                                          //close the scanner
        }

        try (Scanner buffer = new Scanner(new File("test_data.txt"))) {     //the scanner used to load the training set to the test[][] array from the test_data.txt
            for (int i = 0; i < TEST_SIZE; i++) {                                    //loop goes from 0 to the TEST_SIZE
                for (int j = 0; j < FEATURE_SIZE; j++) {                             //loop goes from 0 to the FEATURE_SIZE
                    if (buffer.hasNextDouble()) {                                    //if the file has the next value of the type double, then
                        test[i][j] = buffer.nextDouble();                            //write the next double from the file to the corresponding position [TEST_SIZE][FEATURE_SIZE] in the array test, therefore each of 200 (patterns) rows will contain 61 (features) columns  
                    }
                }
            }
            buffer.close();                                                          //close the scanner
        }

        try (Scanner buffer = new Scanner(new File("test_label.txt"))) {    //the scanner used to load the training set to the test_label[] array from the test_label.txt
            for (int i = 0; i < TEST_SIZE; i++) {                                    //loop goes from 0 to the TEST_SIZE
                if (buffer.hasNextInt()) {                                           //if the file has the next value of the type int, then (here I use int, instead of double (how it was in the previous two scanners), as the class labels are either 0s or 1s, which are of type int )
                    test_label[i] = buffer.nextInt();                                //write the next int from the file to the corresponding position [TEST_SIZE] in the array test_label  
                }
            }
            buffer.close();                                                          //close the scanner
        }

        try (Scanner buffer = new Scanner(new File("train_label.txt"))) {   //the scanner used to load the training set to the train_label[] array from the train_label.txt
            for (int i = 0; i < TRAIN_SIZE; i++) {                                   //loop goes from 0 to the TRAIN_SIZE
                if (buffer.hasNextInt()) {                                           //if the file has the next value of the type int, then
                    train_label[i] = buffer.nextInt();                               //write the next int from the file to the corresponding position [TRAIN_SIZE] in the array test_label
                }
            }
            buffer.close();                                                          //close the scanner
        }

        for (int i = 0; i < TEST_SIZE; i++) {                                       //loop goes from 0 to the TEST_SIZE; these nested loops ((for (int i = 0; i < TEST_SIZE; i++) {) & (for (int j = 0; j < TRAIN_SIZE; j++) {)) allow to find the distance between each feature in train and test
            double[][] distNNo = new double[TRAIN_SIZE][2];                         //the 2d array distNNo that will store the distance between the features in the train and the test data, and the corresponding index of this distance; we find the distance between 200 points in train and the point in test, therefore there will be 200 distances, which is equal to TRAIN_SIZE, therefore there will be 200 (=TRAIN_SIZE) rows; the number of columns I set to 2 - the column in position [0] will store the distance, column [1] will store the corresponding index

            double dist = 0;                                                        //declare the dist variable, that will store a distance between test and train features
            for (int j = 0; j < TRAIN_SIZE; j++) {                                  //loop goes from 0 to the TRAIN_SIZE; these nested loops ((for (int i = 0; i < TEST_SIZE; i++) {) & (for (int j = 0; j < TRAIN_SIZE; j++) {)) allow to find the distance between each feature in train and test

                dist = EucledeanDistance(test[i], train[j]);                        //distance is equal to the return of the call to the EucledeanDistance method with arrays test in the position [i] and train in the position [j] 
                distNNo[j][0] = dist;                                               //the distance is stored in the position [j][0] in the 2d array distNNo
                distNNo[j][1] = j;                                                  //the corresponding to the distance index is stored in the position [j][1] in the 2d array distNNo
            }

            Arrays.sort(distNNo, new Comparator<double[]>() {                       //call for Arrays.sort method, that will sort the distNNo array using the Comparator; I can use it since the 2d array distNNo is the array of arrays
                public int compare(double[] a, double[] b) {                        //comapre method is used to determine the order of the two double[] arrays a and b
                    return Double.compare(a[0], b[0]);                              //compare the first elements of the two arrays (a[0] and b[0]) using Double.compare; if a[0] < b[0], negative number returned, place a before b; if a[0] > b[0], positive number returned, place a after b; if a[0] = b[0], zero returned, no change
                }
            });

            int count_ones = 0;                                                     //declare the count_ones variable, that I will use later to determine the class (0 or 1), using math logic

            if (k == 1) {                                                           //the specific case for k==1 is used; explained why later in the comments
                int chooseIndex = (int) distNNo[0][1];                              //variable chooseIndex is declared; it is used as a temp variable in order to change the type of the indexes stored in distnNNo from double to int, since we are going to use them as indexes once again in order to obtain the corresponding label from the train_label array; we only use distNNo[0][1] (not distNNo[z][1], for example), since k=1 and we only need the first index.

                predict[i] = train_label[chooseIndex];                              //store the class label from the array train_label in the position [chooseIndex] in the predict array in the position [i]; the predicted value is chosen from the train_label[chooseIndex], since chooseIndex is the index of the minimum distance found previously, so we choose the corresponding class label from the train_label

            } else {                                                                //if k is not 1 then
                for (int z = 0; z < k; z++) {                                       //loop from 0 to k; choose k nearest neighbours
                    int chooseIndex = (int) distNNo[z][1];                          //variable chooseIndex is declared; it is used as a temp variable in order to change the type of the indexes stored in distnNNo from double to int, since we are going to use them as indexes once again in order to obtain the corresponding label from the train_label array;
                    count_ones += train_label[chooseIndex];                         //I use the math logic to determine whether class label is 0 or 1; it's done to optimise the program; the value is chosen from the train_label[chooseIndex], since chooseIndex is the index of the minimum distance found previously, so we choose the corresponding class label from the train_label; we sum 0s and 1s
                }

                if (count_ones > k / 2) {                                           //if the sum count_ones is bigger than k / 2, then...; the logic is that we sum 0s and 1s - if there are more 1s, then the sum of them will be bigger then the half of the k-number, vice versa. for example: k = 3, class labels are 1,1,0, therefore sum = 2, k/2 (int 3 / int 2 = int 1) = 1, sum > k/2, therefore predict[i] = 1, as there are more 1s class labels; we have a separate case for k = 1, as int 1 / int 2 is 0 in java, therefore predict[i] will always be 1
                    predict[i] = 1;                                                 //predict[i] is set to 1
                } else {                                                            //if the sum count_ones is less than k / 2, then
                    predict[i] = 0;                                                 //predict[i] is set to 0
                }

            }

        }

        int correct_count = 0;                                                      //declare the correct_count variable that will count the correct predictions
        for (int v = 0; v < TEST_SIZE; v++) {                                       //loop goes from 0 to TEST_SIZE
            if (test_label[v] == predict[v]) {                                      //if the class label in test_label[v] is equal to the class label in array predict in position [v] then
                correct_count = correct_count + 1;                                  //there is a correct predict - increase the correct_count by 1
            }
        }

        double corrent_count_double = (double) correct_count;                       //convert correct_count to double to insure the correctness of the calculation; I want all the variables in the calculation to have the same type
        double TEST_SIZE_DOUBLE = (double) TEST_SIZE;                               //convert TEST_SIZE to double to insure the correctness of the calculation; I want all the variables in the calculation to have the same type
        double accuracy = (corrent_count_double / TEST_SIZE_DOUBLE) * 100;          //find the accuracy of the algorithm, using the formula: (number of correct predictions / total number of class labels) * 100;

        System.out.println("ACCURACY: " + accuracy + "%");                          //output the accuracy of the algorithm

        try {
            PrintWriter writer = new PrintWriter("output1.txt");           //create a text file that will contain the output of the predict array
            for (int j = 0; j < TEST_SIZE; j++) {
                writer.print(predict[j] + " ");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static double EucledeanDistance(double[] test, double[] train) {         //a method to find the Eucledean distance between features, which takes arrays test and train as parameters
        double sum = 0;                                                             //declare the variable sum 
        for (int i = 0; i < FEATURE_SIZE; i++) {                                    //loop goes from 0 to FEATURE_SIZE
            sum += ((test[i] - train[i]) * (test[i] - train[i]));                   //sum variable takes the sum of the square difference between test[i] and train[i] features
        }

        return Math.sqrt(sum);                                                      //method returns the Eucledean distance, using the Math.sqrt
    }

}