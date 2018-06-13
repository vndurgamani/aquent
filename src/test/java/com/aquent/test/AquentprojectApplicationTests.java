package com.aquent.test;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.zip.DataFormatException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AquentprojectApplicationTests {
	// 1. If we are unable to find the file
	@Test
	public void testGetFile() throws IOException{ 
		
		try {
            FileReader reader = new FileReader("test.txt");
            reader.read();
            reader.close();
            fail("File Not Found Exception is thrown");
        } catch (IOException e) {
            System.out.println(e);
        }
	}

	//2. If having no space between Order and time
	@Test
	public void testGetInputNoSpace() throws DataFormatException{ 
		
		try {
            FileReader reader = new FileReader("test.txt");
            reader.read();
            reader.close();
            fail("Data Format Exception is thrown");
        } catch (IOException e) {
            System.out.println(e);
        }
	}
	
	//3. if give only Order not time
	@Test
	public void testGetCorrectInputNoTime() throws DataFormatException{ 
		
		try {
            FileReader reader = new FileReader("test.txt");
            reader.read();
            reader.close();
            fail("Data Format Exception is thrown");
        } catch (IOException e) {
            System.out.println(e);
        }
	}
	
	//4. if given only time no order
	@Test
	public void testGetCorrectInputNoOrder() throws DataFormatException{ 
		
		try {
            FileReader reader = new FileReader("test.txt");
            reader.read();
            reader.close();
            fail("Data Format Exception is thrown");
        } catch (IOException e) {
            System.out.println(e);
        }
	}
	
	//5. Date is in Alpha Numeric
	@Test
	public void testDateInWrongFormat() throws DataFormatException{ 
		
		try {
            FileReader reader = new FileReader("test.txt");
            reader.read();
            reader.close();
            fail("Data Format Exception is thrown- Date is in wrong Format");
        } catch (IOException e) {
            System.out.println(e);
        }
	}
}
