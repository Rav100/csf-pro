## https://eggjs.org/en/intro/quickstart.html

mkdir egg-example

$ cd egg-example

npm init

## add egg 
npm i egg --save

npm i egg-bin --save-dev

## add egg-sequelize && mysql2
npm install --save egg-sequelize mysql2

## add templates for Rendering
npm i egg-view-nunjucks --save

## add jwt (token)
npm install jsonwebtoken

## add validate
npm i egg-validate

## add unit test
npm i egg-mock --save-dev

npm i factory-girl  --save-dev

## 解决跨域问题
npm i egg-cors --save

## run
npm run dev

## test
npm test

## deploy
npm install --production

npm i egg-scripts --save
