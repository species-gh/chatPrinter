package de.chatPrinter.test;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import de.chatPrinter.tools.*;
import de.chatPrinter.data.Message;
import de.chatPrinter.enums.*;

public class ChatLoaderTest {


	@Test
	public void testRead() {
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s);
		s = s.replaceAll("converter/Chattex$", "");
		ChatLoader loader = new ChatLoader(s + "example_data/wa_chat", ChatFormat.WHATSAPP);
		List<Message> wa = loader.read();
		loader = new ChatLoader(s + "example_data/skype_chat", ChatFormat.SKYPE);
		List<Message> sk = loader.read();
		System.out.println("\nWhatsApp:");
		for (Message msg : wa) {
			System.out.println(msg.toString());
		}
		System.out.println("\nSkype:");
		for (Message msg : sk)
			System.out.println(msg.toString());
	}

}