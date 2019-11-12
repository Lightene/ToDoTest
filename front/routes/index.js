import express from 'express';
import axios from 'axios';

const router = express.Router();

const list_URL = 'http://localhost:3200/api/todo/list';

/* GET home page. */
router.get('/', (req, res, next) => {
    axios.get(list_URL)
        .then((response) => {
            console.log(response.data);
            if (response.data !== null)
                res.render('index', {title: 'todo-list', data: response.data});
            else
                res.render('index', {title: 'todo-list', data: ''});
        })
        .catch((err) => {
            console.log(err.response);
            res.render('index', {title: 'todo-list', data: null});
        })
});

//  리스트 생성
router.post('/list', (req, res, next) => {
    console.log(req.body);
    axios.post(list_URL, req.body)
        .then(response => {
            res.send(response);
        })
        .catch(err => {
            console.log(err.response);
            res.send(err.status);
        })
});

//  리스트 수정
router.put('/list', (req, res, next) => {
    console.log(req);
    axios.put('http://localhost:3200/api/todo/list/?idx=' + req.body.idx + '&title=' + req.body.title)
        .then(response => {
            res.sendStatus(response.status);
        })
        .catch(err => {
            console.log(err.response);
        })
});

// check 변동
router.put('/list/check', (req,res,next)=>{
    console.log(req.body.idx);
    axios.put('http://localhost:3200/api/todo/list/check/?idx=' + req.body.idx + '&check=' + req.body.check)
        .then(response => {
            console.log(response);
            res.sendStatus(response.status);
        })
        .catch(err => {
            console.log("ee")
            console.log(err.response);
        });
});

//  리스트 삭제
router.delete('/list', (req, res, next) => {
    console.log(req.body);
    axios({
        method: 'delete',
        url: list_URL + '/' + req.body.idx,
    })
        .then(response => {
            res.sendStatus(response.status);
        })
        .catch(err => {
            console.log(err.response);
        })
});

module.exports = router;
