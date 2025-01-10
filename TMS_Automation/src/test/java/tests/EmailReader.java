//package tests;
//
//import org.openqa.selenium.WebDriver;
//
//import javax.mail.*;
//import javax.mail.search.FlagTerm;
//import java.util.Properties;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class EmailReader {
//WebDriver driver;
//        public static String fetchOTP(String host, String port, String email, String password) {
//                String otp = null;
//
//                try {
//                        // Set up properties for the IMAP server
//                        Properties properties = new Properties();
//                        properties.put("mail.store.protocol", "imaps");
//                        properties.put("mail.imap.host", host);
//                        properties.put("mail.imap.port", port);
//
//                        // Connect to the mail server
//                        Session session = Session.getDefaultInstance(properties, null);
//                        Store store = session.getStore("imaps");
//                        store.connect(host, email, password);
//
//                        // Open the inbox folder
//                        Folder inbox = store.getFolder("INBOX");
//                        inbox.open(Folder.READ_WRITE);
//
//                        // Search for unread emails
//                        Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
//                        System.out.println("Total Unread Messages: " + messages.length);
//
//                        for (Message message : messages) {
//                                String subject = message.getSubject();
//                                if (subject.contains("OTP")) { // Adjust based on your email subject
//                                        String content = message.getContent().toString();
//                                        System.out.println("Email Found: " + content);
//
//                                        // Extract OTP using regex
//                                        Pattern pattern = Pattern.compile("\\b\\d{6}\\b"); // Adjust for your OTP format
//                                        Matcher matcher = pattern.matcher(content);
//                                        if (matcher.find()) {
//                                                otp = matcher.group();
//                                                System.out.println("OTP Found: " + otp);
//                                                break;
//                                        }
//                                }
//                        }
//
//                        // Close folder and store
//                        inbox.close(false);
//                        store.close();
//
//                } catch (Exception e) {
//                        e.printStackTrace();
//                }
//                return otp;
//        }
//
//        public static void main(String[] args) {
//                String host = "imap.gmail.com"; // For Gmail
//                String port = "993";
//                String email = "nimeshamadhushani100@gmail.com";
//                String password = "199993nime"; // Use app password if 2FA is enabled
//
//                String otp = fetchOTP(host, port, email, password);
//                System.out.println("Extracted OTP: " + otp);
//        }
//}
