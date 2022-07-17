package com.meli.examen.service.impl;

import com.meli.examen.service.IDnaAnalizer;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class DnaAnalizerImpl implements IDnaAnalizer {

    @Override
    public int analizeDna(char[][] sequence) {
        int sequencesFound = 0;
        for (int i = 0; i < sequence.length; i++) {
            for (int j = 0; j < sequence.length; j++) {
                char nitrogenBase = sequence[i][j];
                boolean indexIIsLow = i < sequence.length - 3;
                boolean indexJIsLow = j < sequence.length - 3;
                boolean indexJIsHigh = j > sequence.length - 3;

                if (indexJIsLow && this.matchInHorizontalAnalysis(sequence, nitrogenBase, i, j)) {
                    sequencesFound++;
                }

                if (indexIIsLow && this.matchInVerticalAnalysis(sequence, nitrogenBase, i, j)) {
                    sequencesFound++;
                }

                if (indexIIsLow && indexJIsLow && this.matchInMainDiagonalAnalysis(sequence, nitrogenBase, i, j)) {
                    sequencesFound++;
                }

                if (indexIIsLow && indexJIsHigh
                        && this.matchInSecondaryDiagonalAnalysis(sequence, nitrogenBase, i, j)) {
                    sequencesFound++;
                }
            }
        }
        return sequencesFound;
    }

    @Override
    public boolean matchInHorizontalAnalysis(char[][] sequence, char nitrogenBase, int row, int col) {
        return sequence[row][col + 1] == nitrogenBase && sequence[row][col + 2] == nitrogenBase
                && sequence[row][col + 3] == nitrogenBase;
    }

    @Override
    public boolean matchInVerticalAnalysis(char[][] sequence, char nitrogenBase, int row, int col) {
        return sequence[row + 1][col] == nitrogenBase && sequence[row + 2][col] == nitrogenBase
                && sequence[row + 3][col] == nitrogenBase;
    }

    @Override
    public boolean matchInMainDiagonalAnalysis(char[][] secuence, char nitrogenBase, int row, int col) {
        return secuence[row + 1][col + 1] == nitrogenBase && secuence[col + 2][row + 2] == nitrogenBase
                && secuence[row + 3][col + 3] == nitrogenBase;
    }

    @Override
    public boolean matchInSecondaryDiagonalAnalysis(char[][] sequence, char nitrogenBase, int row, int col) {
        return sequence[row + 1][col - 1] == nitrogenBase && sequence[row + 2][col - 2] == nitrogenBase
                && sequence[row + 3][col - 3] == nitrogenBase;
    }
}
