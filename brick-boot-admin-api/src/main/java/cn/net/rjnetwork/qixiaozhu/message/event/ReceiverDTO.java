package cn.net.rjnetwork.qixiaozhu.message.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Public receiver DTO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiverDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String userName;
    private String email;
    private String phone;
    private String wecomUserId;
    private String dingtalkUserId;
    private String larkOpenId;
    private String wechatOpenId;
    private String qqUserId;
    private List<Long> deptIds;
    private Long companyId;
    private String receiverType;

    public static ReceiverDTO createByEmail(String email) {
        return ReceiverDTO.builder().email(email).build();
    }

    public static ReceiverDTO createByPhone(String phone) {
        return ReceiverDTO.builder().phone(phone).build();
    }

    public static ReceiverDTO createByWecomUserId(String wecomUserId) {
        return ReceiverDTO.builder().wecomUserId(wecomUserId).build();
    }

    public static ReceiverDTO createFull(Long userId, String userName, String email, String phone) {
        return ReceiverDTO.builder()
                .userId(userId)
                .userName(userName)
                .email(email)
                .phone(phone)
                .build();
    }
}
