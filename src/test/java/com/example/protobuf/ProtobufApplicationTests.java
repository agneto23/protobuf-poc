package com.example.protobuf;
import com.boomsecret.protobuf.UserLogin;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import util.HttpUtils;
import java.net.URI;

@SpringBootTest
class ProtobufApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	public void test() {
		try {
			URI uri = new URI("http", null, "127.0.0.1", 8080, "/demo/test", "", null);
			HttpPost request = new HttpPost(uri);
			UserLogin.User.Builder builder = UserLogin.User.newBuilder();
			builder.setEmail("email@email.com");
			HttpResponse response = HttpUtils.doPost(request, builder.build());
			UserLogin.UsersList messageUserLoginResponse = UserLogin.UsersList.parseFrom(response.getEntity().getContent());
			System.err.println(messageUserLoginResponse);
		} catch (Exception e) {

		}
	}
}