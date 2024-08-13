package admin.api;


import admin.dto.UserAuthDTO;
import base.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "cloud-admin")
public interface UserFeignClient {

    @GetMapping("/api/v1/users/username/{username}")
    R<UserAuthDTO> getUserByUsername(@PathVariable String username);

    @GetMapping("/api/v1/users/member/username/{username}")
    R<UserAuthDTO> getMemberUserByUsername(@PathVariable String username);
}
