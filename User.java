package com.company;

import java.util.Scanner;

public class User extends Player {
    public User(Boolean changingColorPermission) {
        super(changingColorPermission);
    }

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
