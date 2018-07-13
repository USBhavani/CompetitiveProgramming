import java.util.HashMap;
import java.util.Random;


class UrlShortener
{

	static class URLShortener 
	{

		private HashMap<String, String> keyMap;
		private HashMap<String, String> valueMap;

		private char ch[];

		private Random rand; 
		private int keyLen;

		// Default Constructor
		URLShortener() 
		{
			keyMap = new HashMap<String, String>();
			valueMap = new HashMap<String, String>();
			rand = new Random();
			keyLen = 8;
			ch = new char[62];
			for (int i = 0; i < 62; i++) 
			{
				int j = 0;
				if (i < 10) 
				{
					j = i + 48;
				} 
				else if (i > 9 && i <= 35) 
				{
					j = i + 55;
				} 
				else 
				{
					j = i + 61;
				}
				ch[i] = (char) j;
			}
		}


		URLShortener(int length) 
		{
			this();
			this.keyLen = length;
		}


		public String shortenURL(String remUrl) 
		{
			String shortURL = "";
			if (validateURL(remUrl)) 
			{
				remUrl = sanitizeURL(remUrl);
				int i=0;
				String s = "";
				while(i<remUrl.length())
				{
					if(remUrl.charAt(i)=='/')
					{
						break;
					}
					s += remUrl.charAt(i);
					i++;
				}
				if (valueMap.containsKey(remUrl)) 
				{
					shortURL = s + "/" + valueMap.get(remUrl);
				} 
				else 
				{
					shortURL = s + "/" + getKey(remUrl);
				}
			}

			return shortURL;
		}


		boolean validateURL(String url) 
		{
			return true;
		}

		String sanitizeURL(String url) 
		{
			if (url.substring(0, 7).equals("http://"))
				url = url.substring(7);

			if (url.substring(0, 8).equals("https://"))
				url = url.substring(8);

			if (url.charAt(url.length() - 1) == '/')
				url = url.substring(0, url.length() - 1);
			return url;
		}

		private String getKey(String remUrl) 
		{
			String key;
			key = generateKey();
			keyMap.put(key, remUrl);
			valueMap.put(remUrl, key);
			return key;
		}

		// generateKey
		private String generateKey() 
		{
			String key = "";
			boolean flag = true;
			while (flag) 
			{
				key = "";
				for (int i = 0; i < keyLen; i++) 
				{
					key += ch[rand.nextInt(62)];
				}
				if (!keyMap.containsKey(key)) 
				{
					flag = false;
				}
			}
			return key;
		}
	}

	// test 
	public static void main(String args[]) 
	{
		URLShortener u = new URLShortener(5);

		String urls[] = { 	"www.bing.com/", 
							"www.bing.com",
							"http://www.google.com", 
							"www.google.com/", 
							"www.snapdeal.com",
							"www.snapdeal.com/page1.php", 
							"www.snapdeal.com/page2.php",
							"www.flipkart.in" };

		for (int i = 0; i < urls.length; i++) 
		{
			System.out.println("URL:" + urls[i] + "\tShortened Url: " + u.shortenURL(urls[i]));
		}
	}
}