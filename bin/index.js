#!/usr/bin/env node

const program = require('commander');
// Require logic.js file and extract controller functions using JS destructuring assignment
const { initializeProject, createPage } = require('../lib/init.js');

program
  .version('0.0.1')
  .description('Contact management system');

program
  .command('create <projectName>')
  .alias('c')
  .description('Bootstrap project')
  .action((projectName) => {
    initializeProject(projectName);
  });

program
  .command('add <pageName>')
  .alias('a')
  .description('Add a page')
  .action((pageName) => {
    createPage(pageName);
  });

program.parse(process.argv);

