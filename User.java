package com.company;

import java.util.Scanner;

public class User extends Player {

    /**
     * @param changingColorPermission permission to changing color
     * @param imHumn                  permission to do somthing just human can do it
     */
    public User(Boolean changingColorPermission, Boolean imHumn) {
        super(changingColorPermission, imHumn);
    }

    /**
     * scanning the code that user type it
     * and change it to the location
     *
     * @return where that we want to put our Cell
     */
    public int scanning() {
        Scanner Input = new Scanner(System.in);
        int counter = 0;
        while (true) {
            if (counter > 0)
                System.out.println("\u001b[47m can't scan your code :  \u001b[0m    ");
            String str = Input.next();
            char x = str.charAt(0);
            char y = str.charAt(1);
            int x1 = Character.getNumericValue(x);
            int y1 = Character.getNumericValue(y);
            y1 -= 9;
            int numberOfCell = 8 * (x1 - 1) + y1 - 1;
            if (x1 <= 8 && y1 <= 8)
                return numberOfCell;
            counter++;
        }
    }
}
