package cn.org.alan.exam.service.impl;

import cn.org.alan.exam.mapper.ExamQuAnswerMapper;
import cn.org.alan.exam.model.entity.ExamQuAnswer;
import cn.org.alan.exam.model.vo.exam.PaperQuAnswerExtVO;
import cn.org.alan.exam.service.IExamQuAnswerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WeiJin
 * @since 2024-03-21
 */
@Service
public class ExamQuAnswerServiceImpl extends ServiceImpl<ExamQuAnswerMapper, ExamQuAnswer> implements IExamQuAnswerService {

    @Override
    public List<PaperQuAnswerExtVO> listForExam(String examId, String questionId) {
        return baseMapper.list(examId, questionId);
    }

    @Override
    public List<ExamQuAnswer> listForFill(Integer examId, Integer questionId) {
        QueryWrapper<ExamQuAnswer> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(ExamQuAnswer::getExamId, examId)
                .eq(ExamQuAnswer::getQuestionId, questionId);

        return this.list(wrapper);
    }

    @Override
    public void updateByKey(ExamQuAnswer equ) {
        //查询条件
        QueryWrapper<ExamQuAnswer> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ExamQuAnswer::getExamId, equ.getExamId())
                .eq(ExamQuAnswer::getQuestionId, equ.getQuestionId());

        this.update(equ, wrapper);
    }

}
