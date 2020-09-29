const fs = require('fs');
const path = require("path");
var Handlebars = require("handlebars");

const CURR_DIR = process.cwd();

const initializeProject = (projectName) => {
  const templatePath = path.resolve(__dirname) + '/../templates/project';
  const targetDir = `${CURR_DIR}/${projectName}`
  fs.mkdirSync(targetDir);
  fs.appendFile(targetDir + '/.gitignore',
  `/*.log
/target 	
/*-init.clj
/resources/public/js
.rebel_redline_history
.idea
.iml
.#*
.shadow-cljs
.cpcache
node_modules
.nrepl-port
out
.iml`, function (err) {
               if (err) {
                 console.error(err)
               } else {
                 console.log("Generated .gitingore")
               }
  })
  createDirectoryContents(templatePath, targetDir,  {"projectname" : projectName});
}

const createPage = (pageName) => {
  const projectName = fs.readdirSync("src/main")[0]
  console.log("Creating new view for:", projectName)
  const templatePath = path.resolve(__dirname) + '/../templates/project/src/main/projectname/home';

  const targetDir  = `${CURR_DIR}/src/main/${projectName}/${pageName}`
  if (!fs.existsSync(targetDir)){
    fs.mkdirSync(targetDir);
  }
  createDirectoryContents(templatePath, targetDir, {"projectname" : projectName,
                                                    "home" : pageName,
                                                    "Home page" : pageName.charAt(0).toUpperCase() + pageName.slice(1)});
}

function createDirectoryContents (templatePath, newProjectPath, data) {
  const filesToCreate = fs.readdirSync(templatePath);

  filesToCreate.forEach(file => {
    const origFilePath = `${templatePath}/${file}`;
     
    // get stats about the current file
    const stats = fs.statSync(origFilePath);

    if (stats.isFile()) {
      console.log("Copying file: ", file, " to:", `${newProjectPath}/${file}`)
      var contents = fs.readFileSync(origFilePath, 'utf8');
      try {
          for (const [key, value] of Object.entries(data)) {
            contents = contents.replace(new RegExp(key, 'g'), value)
          }
          const writePath = `${newProjectPath}/${file}`;
          fs.writeFileSync(writePath, contents, 'utf8');
      } 
      catch (e) {
          console.log("Skipping " + file)
          console.error(e)
      }

    } else if (stats.isDirectory()) {
     var targetDir = file;
     for (const [key, value] of Object.entries(data)) {
       targetDir= targetDir.replace(new RegExp(key, 'g'), value)
     }
     fs.mkdirSync(`${newProjectPath}/${targetDir}`);
     createDirectoryContents(`${templatePath}/${file}`, `${newProjectPath}/${targetDir}`, data);
    }
  });
}

module.exports = {initializeProject, createPage};

