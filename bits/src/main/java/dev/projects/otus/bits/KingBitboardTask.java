package dev.projects.otus.bits;

import dev.projects.otus.testsystem.ITask;

import java.math.BigInteger;
import java.util.List;

public class KingBitboardTask extends AbstractBitboardTask implements ITask {

    private final BigInteger sevenShift = new BigInteger("7", 10),
            eightShift = new BigInteger("8", 10),
            nineShift = new BigInteger("9", 10),
            oneShift = new BigInteger("1", 10);

    private final BigInteger notA = new BigInteger("FEFEFEFEFEFEFEFE", 16),
            notH = new BigInteger("7F7F7F7F7F7F7F7F", 16),
            notUp = new BigInteger("ffffffffffffff", 16),
            notDown = new BigInteger("ffffffffffffff00", 16);

    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        BigInteger kingPosition = new BigInteger(inArgs.get(0), 10),
                kingBits = new BigInteger("1", 10).shiftLeft(kingPosition.intValue()),
                Ka = kingBits.and(notA),
                Kh = kingBits.and(notH);

        BigInteger kingMovesBits = Ka.and(notUp).shiftLeft(sevenShift.intValue())
                .or(kingBits.and(notUp).shiftLeft(eightShift.intValue()))
                .or(Kh.and(notUp).shiftLeft(nineShift.intValue()))
                .or(Ka.shiftRight(oneShift.intValue()))
                .or(Kh.shiftLeft(oneShift.intValue()))
                .or(Ka.and(notDown).shiftRight(nineShift.intValue()))
                .or(kingBits.and(notDown).shiftRight(eightShift.intValue()))
                .or(Kh.and(notDown).shiftRight(sevenShift.intValue())),

                movesCountV1 = countBits(kingMovesBits),
                movesCountV2 = countBitsV2(kingMovesBits);

        boolean kingMovesCountV1IsCorrect = movesCountV1.compareTo(new BigInteger(outArgs.get(0), 10)) == 0,
                kingMovesCountV2IsCorrect = movesCountV2.compareTo(new BigInteger(outArgs.get(0),10)) == 0,
                kingBitMaskIsCorrect = kingMovesBits.compareTo(new BigInteger(outArgs.get(1), 10)) == 0;

        return kingMovesCountV1IsCorrect && kingMovesCountV2IsCorrect && kingBitMaskIsCorrect;
    }

    private BigInteger countBits(BigInteger kingBits) {
        BigInteger tempKingBits = new BigInteger(kingBits.toString(), 10),
                movesCount = new BigInteger("0", 10),
                zero = new BigInteger("0", 10);

        while (!tempKingBits.equals(zero)) {
            tempKingBits = tempKingBits.and(new BigInteger(tempKingBits.toString(), 10).subtract(new BigInteger("1", 10)));

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
