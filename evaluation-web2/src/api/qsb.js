import request from '../utils/interceptors.js';
// 获取正在建设的题库
export const getBuildingBank = params => {
    return request({
        url: '/v1/ques-banks/my/incomplete',
        method: 'get',
        params
    });
};
// 获取完成建设的题库
export const getCompletedBank = params => {
    return request({
        url: '/v1/ques-banks/my/complete',
        method: 'get',
        params
    });
};
// 题库结项
export const doComplete = id => {
    return request({
        url: '/v1/ques-banks/' + id + '/doComplete',
        method: 'put',
    });
};

// 题库启用
export const doEnable = id => {
    return request({
        url: '/v1/ques-banks/' + id + '/doEnable',
        method: 'put',
    });
};

// 题库禁用
export const doDisable = id => {
    return request({
        url: '/v1/ques-banks/' + id + '/doDisable',
        method: 'put',
    });
};

// 查看题库信息
export const getBankInfo = id => {
    return request({
        url: '/v1/ques-banks/' + id + '/part1',
        method: 'get',
    });
};

// 新建题库
export const createBank = data => {
    return request({
        url: '/v1/ques-banks/part1',
        method: 'post',
		data
    });
};

// 编辑题库
export const editBank = (id,data) => {
    return request({
        url: '/v1/ques-banks/' + id + '/part1',
        method: 'put',
		data
    });
};

// 获取人员
export const getUsers = params => {
    return request({
        url: '/v1/users',
        method: 'get',
		params
    });
};

// 获取教材
export const getTextbooks = params => {
    return request({
        url: '/v1/textbooks',
        method: 'get',
		params
    });
};

// 获取课程
export const getCourses = params => {
    return request({
        url: '/v1/courses',
        method: 'get',
		params
    });
};

// 获取用途
export const getUsages = params => {
    return request({
        url: '/v1/usages',
        method: 'get',
		params
    });
};

// 获取操作日志
export const getEventLog = (id,params) => {
    return request({
        url: '/v1/ques-banks/' + id + '/part4',
        method: 'get',
		params
    });
};

// 获取任务分配
export const getAss = (id,params) => {
    return request({
        url: '/v1/ques-banks/' + id + '/part3',
        method: 'get',
		params
    });
};

// 获取关联学科/能力
export const getSubjectAbility = id => {
    return request({
        url: '/v1/ques-banks/' + id + '/part2',
        method: 'get'
    });
};

// 获取一级学科
export const getSubject1 = params => {
    return request({
        url: '/v1/subject1s',
        method: 'get',
		params
    });
};

// 获取二级学科
export const getSubject2 = params => {
    return request({
        url: '/v1/subject2s',
        method: 'get',
		params
    });
};

// 获取一级能力
export const getAbility1 = params => {
    return request({
        url: '/v1/ability1s',
        method: 'get',
		params
    });
};

// 获取二级能力
export const getAbility2 = params => {
    return request({
        url: '/v1/ability2s',
        method: 'get',
		params
    });
};

// 提交能力和学科
export const setSubjectAbility = (id,data) => {
    return request({
        url: '/v1/ques-banks/{题库id}/part2',
        method: 'put',
		data
    });
};