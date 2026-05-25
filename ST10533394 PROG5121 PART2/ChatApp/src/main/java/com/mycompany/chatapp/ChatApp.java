
    
       

        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");

        // Ask how many messages the user wants to send
        int numberOfMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages do you want to send?"));

        // Start menu loop
        boolean keepRunning = true;
        while (keepRunning) {
            String menuChoice = JOptionPane.showInputDialog(
                    "Choose an option:\n1. Send Messages\n2. Show Recently Sent Messages\n3. Quit");

            switch (menuChoice) {
                case "1" -> {
                    for (int i = 0; i < numberOfMessages; i++) {
                        sendMessage(i);
                    }
                }
                case "2" -> JOptionPane.showMessageDialog(null, "Coming Soon.");
                case "3" -> {
                    JOptionPane.showMessageDialog(null, "Total messages sent: " + totalMessagesSent);
                    keepRunning = false;
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please select 1, 2, or 3.");
            }
        }
    }

    public static void sendMessage(int messageNumber) {
        String recipient = JOptionPane.showInputDialog("Enter recipient number (e.g., +27123456789):");

        if (recipient.length() < 10 || !recipient.startsWith("+")) {
            JOptionPane.showMessageDialog(null, "Invalid phone number. Must include international code and be 10 digits.");
            return;
        }

        String messageText = JOptionPane.showInputDialog("Enter your message (max 250 characters):");

        if (messageText.length() > 250) {
            int extra = messageText.length() - 250;
            JOptionPane.showMessageDialog(null, "Message exceeds 250 characters by " + extra + ". Please shorten it.");
            return;
        }

        // Generate a random 10-digit message ID
        String messageID = String.format("%010d", new Random().nextInt(1_000_000_000));

        // Generate the message hash
        String[] words = messageText.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        String messageHash = messageID.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord;
        messageHash = messageHash.toUpperCase();

        // Ask what to do with the message
        String[] options = {"Send Message", "Disregard Message", "Store Message"};
        int choice = JOptionPane.showOptionDialog(null, "Choose what to do with the message:",
                "Message Action", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        String result = "";
        switch (choice) {
            case 0 -> {
                result = "Message successfully sent.";
                totalMessagesSent++;
            }
            case 1 -> result = "Message disregarded.";
            case 2 -> // In future, store message to JSON (not implemented here)
                result = "Message stored for later.";
            default -> {
            }
        }

        JOptionPane.showMessageDialog(null,
                """
                Message Details:
                Message ID: """ + messageID + "\n" +
                        "Message Hash: " + messageHash + "\n" +
                        "Recipient: " + recipient + "\n" +
                        "Message: " + messageText + "\n" +
                        result);
    


    } //end of main method
   
    
}//end of main class