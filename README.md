# re-gen

Generator for initalizing re-frame web application using react, material-ui and router. 

```
npx  https://github.com/rpofuk/re-gen.git create my-name
cd my-name
npx  https://github.com/rpofuk/re-gen.git add home
npm install
shadow-cljs watch app

tree:
├── deps.edn
├── package.json
├── resources
│   └── public
│       ├── devcards.html
│       └── index.html
├── shadow-cljs.edn
└── src
    └── main
        └── test2
            ├── config.cljs
            ├── core.cljs
            ├── db.cljs
            ├── events.cljs
            ├── home
            │   ├── db.cljs
            │   ├── events.cljs
            │   ├── subs.cljs
            │   └── views.cljs
            ├── routes.cljs
            ├── subs.cljs
            └── views.cljs


```
Development

```
node bin/index.js
sudo npm install -g ./
```
