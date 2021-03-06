<?php

/**
 * Application Model Mapper
 *
 * @package Mapper
 * @subpackage Sql
 * @author vvargas
 * @copyright ZF model generator
 * @license http://framework.zend.com/license/new-bsd     New BSD License
 */

/**
 * Data Mapper implementation for Librecon\Model\Assistants
 *
 * @package Mapper
 * @subpackage Sql
 * @author vvargas
 */
namespace Librecon\Mapper\Sql;
class Assistants extends Raw\Assistants
{
    public function save(\Librecon\Model\Raw\Assistants $model)
    {
        $versionUpdater = new \Librecon_Helper_Version();
        $versionUpdater->updateVersion(get_class($this));

        $new = is_null($model->getId());

        if (!$new) {
            //ACTUALIZADOR DE FECHA
            $model->setLastModified(\Zend_Date::now()->setTimezone('UTC'));
        }

        $resp = parent::save($model, false, false);

        return $resp;
    }

    public function delete(\Librecon\Model\Raw\ModelAbstract $model)
    {
        $versionUpdater = new \Librecon_Helper_Version();
        $versionUpdater->updateVersion(get_class($this));

        $result = $this->getDbTable()->delete('id = '.$model->getId());

        return $result;
    }
}
