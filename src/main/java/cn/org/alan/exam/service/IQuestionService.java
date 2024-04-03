package cn.org.alan.exam.service;

import cn.org.alan.exam.common.result.Result;
import cn.org.alan.exam.model.entity.Question;
import cn.org.alan.exam.model.form.QuestionFrom;
import cn.org.alan.exam.model.vo.QuestionVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author WeiJin
 * @since 2024-03-21
 */
public interface IQuestionService extends IService<Question> {

    /**
     * 单题添加
     *
     * @param questionFrom 传参
     * @return 响应
     */
    Result<String> addSingleQuestion(QuestionFrom questionFrom);

    /**
     * 批量删除试题
     *
     * @param ids 试题id
     * @return 响应
     */
    Result<String> deleteBatchByIds(String ids);


    /**
     * 分页查询试题
     *
     * @param pageNum  页码
     * @param pageSize 每页记录数
     * @param content  试题名
     * @param type     试题类型
     * @param repoId   题库id
     * @return 响应
     */
    Result<IPage<QuestionVO>> pagingQuestion(Integer pageNum, Integer pageSize, String content, Integer type, Integer repoId);
}
