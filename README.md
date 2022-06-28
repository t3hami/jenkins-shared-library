# jenkins-shared-library

## Usage

```
library identifier: 'jenkins-shared-library@master', retriever: modernSCM(
  [$class: 'GitSCMSource',
   remote: 'https://github.com/t3hami/jenkins-shared-library.git'])

init{}
```