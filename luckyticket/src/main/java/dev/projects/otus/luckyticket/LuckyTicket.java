package dev.projects.otus.luckyticket;

import dev.projects.otus.testsystem.ITask;

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

        long ticketLength = 2 * Long.parseLong(inArgs.get(0)), actualLuckyTicketCount = 0;

        StringBuffer buffer = generateTicket(ticketLength, "0");

        long endIndex = Long.parseLong(generateTicket(ticketLength, "9").toString());

        for (long index = 0; index <= endIndex; index++) {
           if (isLuckyTicket(buffer)) {
               actualLuckyTicketCount++;
           }

            buffer = incrementBufferByOne(buffer, ticketLength);
        }

        long correctLuckyTicketCount = Long.parseLong(outArgs.get(0));

        return actualLuckyTicketCount == correctLuckyTicketCount;
    }

    private StringBuffer incrementBufferByOne(StringBuffer buffer, long ticketLength) {
        long newValue = Long.parseLong(buffer.toString()) + 1;
        String tempBuffer = String.valueOf(newValue);

        return generateTicket(ticketLength - tempBuffer.length(), "0").append(tempBuffer);
    }

    private StringBuffer generateTicket(long ticketSize, String element) {
        StringBuffer buffer = new StringBuffer();

        for (long index = 0; index < ticketSize; index++) {
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
