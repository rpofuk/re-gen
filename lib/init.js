const fs = require('fs');
const path = require("path");
var Handlebars = require("handlebars");

const CURR_DIR = process.cwd();

const initializeProject = (projectName) => {
  const templatePath = path.resolve(__dirname) + '/../templates/project';
  const targetDir = `${CURR_DIR}/${projectName}`
  fs.mkdirSync(targetDir);

  createDirectoryContents(templatePath, targetDir,  {"projectName" : projectName});
}

const createPage = (pageName) => {
  const projectName = fs.readdirSync("src/main")[0]
  console.log("Creating new view for:", projectName)
  const templatePath = path.resolve(__dirname) + '/../templates/page';

  createDirectoryContents(templatePath, `${CURR_DIR}/src/main/${projectName}`, {"projectName" : projectName, "pageName" : pageName});
}

function createDirectoryContents (templatePath, newProjectPath, data) {
  const filesToCreate = fs.readdirSync(templatePath);

  filesToCreate.forEach(file => {
    const origFilePath = `${templatePath}/${file}`;
     
    // get stats about the current file
    const stats = fs.statSync(origFilePath);

    if (stats.isFile()) {
      const contents = fs.readFileSync(origFilePath, 'utf8');
      try {
          const template = Handlebars.compile(contents)
          rendered = template(data)
          const writePath = `${newProjectPath}/${file}`;
          fs.writeFileSync(writePath, rendered, 'utf8');
      } 
      catch (e) {
          console.log("Skipping " + file)
      }

    } else if (stats.isDirectory()) {
      const template = Handlebars.compile(file)
      targetDir = template(data)
      fs.mkdirSync(`${newProjectPath}/${targetDir}`);
      
      // recursive call
      createDirectoryContents(`${templatePath}/${file}`, `${newProjectPath}/${targetDir}`, data);
    }
  });
}

module.exports = {initializeProject, createPage};

