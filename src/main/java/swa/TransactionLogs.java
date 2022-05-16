package swa;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionLogs {

    public static List<String> processLogs(List<String> logs, int threshold) {
        Map<String, Integer> transactionPerId = new HashMap<>();
        logs.stream().forEach(log -> {
            List<String> logContent = Stream.of(log.split(" ", -1))
                    .collect(Collectors.toList());
            String senderId = logContent.get(0);
            String recipientId = logContent.get(1);
            if(senderId.equals(recipientId)) {
                transactionPerId.put(senderId, transactionPerId.getOrDefault(senderId, 0) + 1);
            } else {
                transactionPerId.put(senderId, transactionPerId.getOrDefault(senderId, 0) + 1);
                transactionPerId.put(recipientId, transactionPerId.getOrDefault(recipientId, 0) + 1);
            }
        });

        List<Integer> userIdOverThreshold = transactionPerId.entrySet().stream()
                .filter(id -> id.getValue() >= threshold)
                .map(id -> Integer.valueOf(id.getKey()))
                .collect(Collectors.toList());
        Collections.sort(userIdOverThreshold);

        return userIdOverThreshold.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
