package dev.projects.otus.luckyticket;

import dev.projects.otus.testsystem.ITask;

import java.util.Arrays;
import java.util.List;

public class LuckyTicket implements ITask {
    @Override
    public boolean run(List<String> inArgs, List<String> outArgs) {
        if ((inArgs == null)
                || (inArgs.isEmpty())
                || (inArgs.size() != 1)) throw new IllegalArgumentException("Unacceptable input args");

        if ((outArgs == null)
                || (outArgs.isEmpty())
                || (outArgs.size() != 1)) throw new IllegalArgumentException("Unacceptable output args");

        int ticketLength = 2 * Integer.parseInt(inArgs.get(0)), actualLuckyTicketCount = 0;

        StringBuffer buffer = generateTicket(ticketLength, "0");

        int endIndex = Integer.parseInt(generateTicket(ticketLength, "9").toString());

        for (int index = 0; index <= endIndex; index++) {
           if (isLuckyTicket(buffer)) {
               actualLuckyTicketCount++;
           }

            buffer = incrementBufferByOne(buffer, ticketLength);
        }

        int correctLuckyTicketCount = Integer.parseInt(outArgs.get(0));

        return actualLuckyTicketCount == correctLuckyTicketCount;
    }

    private StringBuffer incrementBufferByOne(StringBuffer buffer, int ticketLength) {
        int newValue = Integer.parseInt(buffer.toString()) + 1;
        String tempBuffer = String.valueOf(newValue);

        return generateTicket(ticketLength - tempBuffer.length(), "0").append(tempBuffer);
    }

    private StringBuffer generateTicket(int ticketSize, String element) {
        StringBuffer buffer = new StringBuffer();

        for (int index = 0; index < ticketSize; index++) {
            buffer.append(element);
        }

        return buffer;
    }

    private boolean isLuckyTicket(StringBuffer buffer) {
        int size = buffer.length(), half = (int) (size / 2);

        int firstSum = 0, secondSum = 0;

        for (int charIndex = 0; charIndex < half; charIndex++) {
            firstSum += Character.getNumericValue(buffer.charAt(charIndex));
            secondSum += Character.getNumericValue(buffer.charAt(charIndex + half));
        }

        return firstSum == secondSum;
    }
}
