package younghan.querydsl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import younghan.querydsl.dto.MemberSearchCondition;
import younghan.querydsl.dto.MemberTeamDto;

import java.util.List;

public interface MemberRepositoryCustom {

    List<MemberTeamDto> search(MemberSearchCondition condition);

    // 단순한 쿼리용이다.
    Page<MemberTeamDto> searchPageSimple(MemberSearchCondition condition, Pageable pageable);

    // 카운트 쿼리인 것과 아닌 것을 분리해서 별도의 쿼리로 나가게 한다.
    Page<MemberTeamDto> searchPageComplex(MemberSearchCondition condition, Pageable pageable);


}
