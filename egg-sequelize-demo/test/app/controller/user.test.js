const { assert, app } = require('egg-mock/bootstrap');

describe('test/app/service/users.test.js', () => {

  // describe('GET /users', () => {
  //   it('should work', async () => {
  //     // 通过 factory-girl 快速创建 user 对象到数据库中
  //     await app.factory.createMany('user', 3);
  //     const res = await app.httpRequest().get('/users?limit=2');
  //     console.log(res.body);
      
  //     assert(res.status === 200);
  //     assert(res.body.length === 2);
  //     assert(res.body[0].name);
  //     assert(res.body[0].age);
  //   });
  // });

//   describe('GET /users/:id', () => {
//     it('should work', async () => {
//       const user = await app.factory.create('user');
//       const res = await app.httpRequest().get(`/users/${user.id}`);
//       assert(res.status === 200);
//       assert(res.body.age === user.age);
//     });
//   });

  describe('POST /users', () => {
    it('should work', async () => {
      app.mockCsrf();
      let res = await app.httpRequest().post('/users')
        .send({
          age: 10,
          name: 'name',
        });
      assert(res.status === 201);
      assert(res.body.id);
      console.log(res.body);

      res = await app.httpRequest().get(`/users/${res.body.id}`);
    //   console.log(res.body);
      assert(res.status === 200);
    });
  });

//   describe('DELETE /users/:id', () => {
//     it('should work', async () => {
//       const user = await app.factory.create('user');

//       app.mockCsrf();
//       const res = await app.httpRequest().delete(`/users/${user.id}`);
//       assert(res.status === 200);
//     });
//   });

});