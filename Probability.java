import java.util.Scanner;

public class Probability {
    public static void main(String[] args)
    {
        System.out.println("Are we working probabilities or numbers in the Venn Diagram? p or n?");
        Scanner sc = new Scanner(System.in);
        String choice = sc.next();
        if (choice.equals("p"))
        {
            vennDiagram(true);
        } else
        {
            vennDiagram(false);
        }
    }

    public static void vennDiagram(boolean probabilities)
    {
        String a;
        String b;
        double left;
        double m;
        double right;
        int total;
        Scanner sc = new Scanner(System.in);
        System.out.println("Use preloaded values? y or n?");
        String response = sc.next();
        if (response.equals("y"))
        {
            a = "Garage";
            b = "Pool";
            left = 0.64;
            m = 0.17;
            right = 0.21;
        } else
        {
            System.out.println("Enter Venn Diagram Left Title.");
            a = sc.next();
            System.out.println("Enter Venn Diagram Right Title.");
            b = sc.next();
            if (probabilities)
            {
                System.out.println("Enter Venn Diagram Left Probability.");
                left = sc.nextDouble();
                System.out.println("Enter Venn Diagram Middle Probability.");
                m = sc.nextDouble();
                System.out.println("Enter Venn Diagram Right Probability.");
                right = sc.nextDouble();
            } else
            {
                System.out.println("Enter Total of all.");
                total = sc.nextInt();
                System.out.println("Enter Venn Diagram Left Number.");
                left = sc.nextDouble() / total;
                System.out.println("Enter Venn Diagram Middle Number.");
                m = sc.nextDouble() / total;
                System.out.println("Enter Venn Diagram Right Number.");
                right = sc.nextDouble() / total;
            }
        }
        double value = left + m;
        System.out.println("P(" + a + ") = " + left + " + " + m + " = " + value);
        value = right + m;
        System.out.println("P(" + b + ") = " + right + " + " + m + " = " + value);
        value = left - m;
        System.out.println("P(" + a + " and not " + b + ") = " + left + " - " + m + " = " + value);
        value = right - m;
        System.out.println("P(" + b + " and not " + a + ") = " + right + " - " + m + " = " + value);
        value = m;
        System.out.println("P(" + a + " ∩ " + b + ") = " + value);
        value = left + right + m;
        System.out.println("P(" + a + " ∪ " + b + ") = " + left + " + " + right + " + " + m + " = " + value);
        value = 1 - value;
        System.out.println("P(neither) = 1 - (" + left + " + " + right + " - " + m + ") = " + value);
        value = m / (m + right);
        System.out.println("P(" + a + " | " + b + ") = " + m + " / (" + m + " + " + left + ")  = " + value);
        value = m / (m + left);
        System.out.println("P(" + b + " | " + a + ") = " + m + " / (" + m + " + " + right + ") = " + value);
        boolean disjoint = (value == 0);
        boolean independent = (value == right + m);
        if (disjoint)
        {
            System.out.println("Disjoint because P(" + b + " | " + a + ") = 0");
        } else if (independent)
        {
            System.out.println("Independent because P(" + b + " | " + a + ") = P(" + b + ") = " + value);
        } else
        {
            System.out.println("Neither disjoint nor independent because  P(" + b + " | " + a + ") is not 0 or equal to P(" + b + ")");
        }
    }
}
