package ru.geekbrains.lesson5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Game {

    public static void main(String[] args) throws IOException {
        int[][] game = {{0,0,0}, {1,2,2}, {2,0,2}};
        save(game);
    }

    /**
     * Запись состояния игрового поля
     * @param field массив игрового поля с состоянием ячеек
     * @throws IOException
     */
    public static void save(int[][] field) throws IOException {
        int res = 0;
        File save = new File(".//save.txt");
        save.createNewFile();
        try (FileOutputStream fileOutputStream = new FileOutputStream(save)){
            for (int i = 0; i < 3; i++) {
                res = 0;
                for (int j = 0; j < 3; j++) {
                    res = res*10 + field[i][j];
                }
                fileOutputStream.write(res);
            }
        }
        int c = 0;
        try(FileInputStream fileInputStream = new FileInputStream(save)){
            while ((c = fileInputStream.read()) != -1) {
                System.out.println("Проверка: " + c);
            }
        }
    }
}
