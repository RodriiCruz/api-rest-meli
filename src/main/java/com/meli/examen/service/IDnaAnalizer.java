package com.meli.examen.service;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public interface IDnaAnalizer {

    int analizeDna(char[][] sequence);

    boolean matchInHorizontalAnalysis(char[][] sequence, char nitrogenBase, int row, int col);

    boolean matchInVerticalAnalysis(char[][] sequence, char nitrogenBase, int row, int col);

    boolean matchInMainDiagonalAnalysis(char[][] sequence, char nitrogenBase, int row, int col);

    boolean matchInSecondaryDiagonalAnalysis(char[][] sequence, char nitrogenBase, int row, int col);
}
