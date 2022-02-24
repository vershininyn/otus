package dev.projects.otus.bits;

import dev.projects.otus.testsystem.ITask;

import java.math.BigInteger;
import java.util.List;

public class HorseBitboardTask extends AbstractBitboardTask implements ITask {

    private final BigInteger sixShift = new BigInteger("6", 10),
            tenShift = new BigInteger("10", 10),
            fiveteenShift = new BigInteger("15", 10),
            seventeenShift = new BigInteger("17", 10);

    private final BigInteger nA = new BigInteger("FEFEFEFEFEFEFEFE", 16),
            nAB = new BigInteger("FCFCFCFCFCFCFCFC", 16),
            nH = new BigInteger("7F7F7F7F7F7F7F7F", 16),
            nGH = new BigInteger("3F3F3F3F3F3F3F3F", 16);

    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        BigInteger horsePosition = new BigInteger(inArgs.get(0), 10);

        //ulong knightBits = 1 << knightNr;
        BigInteger horseBits = new BigInteger("1", 10).shiftLeft(horsePosition.intValue());

        /*
           movesBits = nGH & (knightBits <<  6 | knightBits >> 10)
             |  nH & (knightBits << 15 | knightBits >> 17)
             | nA  & (knightBits << 17 | knightBits >> 15)
             | nAB & (knightBits << 10 | knightBits >>  6);
         */

        BigInteger nGHCondition = nGH.and(horseBits.shiftLeft(sixShift.intValue()).or(horseBits.shiftRight(tenShift.intValue()))),
                nHCondition = nH.and(horseBits.shiftLeft(fiveteenShift.intValue()).or(horseBits.shiftRight(seventeenShift.intValue()))),
                nACondition = nA.and(horseBits.shiftLeft(seventeenShift.intValue()).or(horseBits.shiftRight(fiveteenShift.intValue()))),
                nABCondition = nAB.and(horseBits.shiftLeft(tenShift.intValue()).or(horseBits.shiftRight(sixShift.intValue())));

        BigInteger horseMovesBits = nGHCondition.or(nHCondition).or(nACondition).or(nABCondition),
                movesCount = countBits(horseMovesBits),
                movesCountV2 = countBitsV2(horseMovesBits);

        boolean horseMovesCountIsCorrect = movesCount.compareTo(new BigInteger(outArgs.get(0), 10)) == 0,
                horseMovesCountV2IsCorrect = movesCountV2.compareTo(new BigInteger(outArgs.get(0),10)) == 0,
                horseBitMaskIsCorrect = horseMovesBits.compareTo(new BigInteger(outArgs.get(1), 10)) == 0;

        return horseMovesCountIsCorrect && horseMovesCountV2IsCorrect && horseBitMaskIsCorrect;
    }

    private BigInteger countBits(BigInteger horseBits) {
        BigInteger tempHorseBits = new BigInteger(horseBits.toString(), 10),
                movesCount = new BigInteger("0", 10),
                zero = new BigInteger("0", 10);

        while (!tempHorseBits.equals(zero)) {
            tempHorseBits = tempHorseBits.and(new BigInteger(tempHorseBits.toString(), 10).subtract(new BigInteger("1", 10)));

            movesCount = movesCount.add(new BigInteger("1", 10));
        }

        return movesCount;
    }

    public BigInteger countBitsV2(BigInteger kingBits) {
        BigInteger bitsCount = new BigInteger("0",10),
                tempKingBits = new BigInteger(kingBits.toString(), 10),
                zero = new BigInteger("0",10),
                one = new BigInteger("1",10);

        while(!tempKingBits.equals(zero)){
            if (tempKingBits.and(one).compareTo(one) == 0) {
                bitsCount = bitsCount.add(one);
            }

            tempKingBits = tempKingBits.shiftRight(one.intValue());
        }

        return bitsCount;
    }
}
